package e;

import java.time.LocalDate;
import java.util.List;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


public class XML {
    private Entries entries;

    public void read() {
        try {
            File file = new File("structured.xml");
    	    JAXBContext jaxbContext =
                                  JAXBContext.newInstance(Entries.class);
    	    Unmarshaller jaxbUnmarshaller =
                                        jaxbContext.createUnmarshaller();
        	this.entries = (Entries) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
        this.fillCode(null, this.entries);
    }

    public void print(String parentCode, boolean recursive) {
        if (parentCode == null) {
       	    System.out.print(this.entries.toString(true));
        } else if (parentCode.length() == 0 || "0".equals(parentCode)){
            System.out.print(this.entries.toString(recursive));
        } else {
            System.out.print(this.findEntryByCode(parentCode).entries
                                                   .toString(recursive));
        }
    }

    @XmlRootElement
    private static class Entries {
        @XmlElement(name = "entry")
        List<Entry> entries;

        @Override
        public String toString() {
            return this.toString(false);
        }

        private String toString(boolean recursive) {
            StringBuilder sb = new StringBuilder();
            for (Entry e : this.entries) {
//                sb.append(String.format("%s %s %s%n", e.updated, e.code,
                sb.append(String.format("%s %s%n", e.code,
                                                         e.description));
            }
            if (recursive) {
                for (Entry e : this.entries) {
                    if (e.entries != null) {
                        sb.append(e.entries);
                    }
                }
            }
            return sb.toString();
        }
    }

    @XmlRootElement
    private static class Entry {
        String code = "test:";
        @XmlAttribute
        int number;
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        @XmlAttribute
        LocalDate updated;
        @XmlElement
        String description;
        @XmlElement
        Entries entries;
    }

    private static class LocalDateAdapter
                                 extends XmlAdapter<String, LocalDate> {
	    public LocalDate unmarshal(String v) throws Exception {
	        return LocalDate.parse(v);
	    }

	    public String marshal(LocalDate v) throws Exception {
	        return v.toString();
	    }
	}

	private void fillCode(String parentCode, Entries entries) {
        if (entries != null) {
           if (parentCode == null) {
                parentCode = "%d";
            } else {
                parentCode += ".%d";
            }
            for (Entry e : entries.entries) {
                e.code = String.format(parentCode, e.number);
                this.fillCode(e.code, e.entries);
            }
        }
    }

    private Entry findEntryByCode(String code) {
        Entry result = null;
        String[] numbers = code.split("\\.");
        int i = 0;
        List<Entry> entries = this.entries.entries;
        do {
            for (Entry e : entries) {
                if (e.number == Integer.parseInt(numbers[i])) {
                    if (++i >= numbers.length) {
                        result = e;
                    } else {
                        entries = e.entries.entries;
                    }
                    break;
                }
            }
        } while (result == null);
        return result;
    }
}
