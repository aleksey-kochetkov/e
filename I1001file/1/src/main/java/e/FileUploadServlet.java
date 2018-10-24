package e;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import java.io.File;
import java.util.List;

public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                                          HttpServletResponse response) {
        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new IllegalStateException();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        File repository = (File) this.getServletContext()
                          .getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> items = upload.parseRequest(request);
            System.out.println(items.size());
        } catch (FileUploadException exception) {
            throw new RuntimeException(exception);
        }
    }
}
