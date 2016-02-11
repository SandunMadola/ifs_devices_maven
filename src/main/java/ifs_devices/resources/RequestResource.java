package ifs_devices.resources;

import ifs_devices.model.Edit_Mode;
import ifs_devices.model.Request;
import ifs_devices.service.RequestService;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.persistence.internal.oxm.conversion.Base64;
//import sun.misc.IOUtils;
//import org.apache.commons.io.IOUtils;
//import com.sun.jersey.core.header.FormDataContentDisposition;
//import com.sun.jersey.multipart.FormDataParam;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.ws.rs.core.Response;
/**
 *
 * @author sanmlk
 */
@Path("/request")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RequestResource {

    RequestService requestService = new RequestService();

    @GET
    public List<Request> getRequest() {/*Get all requested devices from the device table*/
        System.out.println("/request call");
        return requestService.getRequest();
    }

    @POST
    public Request addRequest(Request request) {/*Add new request to the device table*/
        System.out.println("/request call");
        return requestService.addRequest(request);
    }

//    @POST
//    @Path("/image/{ss}")
//    public int addRequest(@PathParam("ss") InputStream input) throws IOException{/*Add new request to the device table*/
//   
//        System.out.println("/request call");
//        byte[] image = IOUtils.toByteArray(input);
////        byte[] image = null;
////        try {
////            image = Base64.base64Decode(IOUtils.toByteArray(input)); //, StandardCharsets.UTF_8));
////            
////        } catch (IOException ex) {
////            Logger.getLogger(RequestResource.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        // = Base64.decodeBase64(IOUtils.toString(input, StandardCharsets.UTF_8));
//        return requestService.addImage(image);
//}"C://Users//sanmlk//Desktop//for/"

//        @POST
//	@Path("/image")
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	public Response uploadFile(
//		@FormDataParam("file") InputStream uploadedInputStream,
//		@FormDataParam("file") FormDataContentDisposition fileDetail) {
//
//		String uploadedFileLocation = "C://Users//sanmlk//Desktop//for/" + fileDetail.getFileName();
//
//		// save it
//		writeToFile(uploadedInputStream, uploadedFileLocation);
//
//		String output = "File uploaded to : " + uploadedFileLocation;
//
//		return Response.status(200).entity(output).build();
//
//	}
//
//	// save uploaded file to new location
//	private void writeToFile(InputStream uploadedInputStream,
//		String uploadedFileLocation) {
//
//		try {
//			OutputStream out = new FileOutputStream(new File(
//					uploadedFileLocation));
//			int read = 0;
//			byte[] bytes = new byte[1024];
//
//			out = new FileOutputStream(new File(uploadedFileLocation));
//			while ((read = uploadedInputStream.read(bytes)) != -1) {
//				out.write(bytes, 0, read);
//			}
//			out.flush();
//			out.close();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//
//	}
       
        

    @PUT
    @Path("/{reqID}") /*Update changes done to the requested device and save in device table*/
    public Request updateRequest(@PathParam("reqID") int id, Request request) {
        request.setId(id);
        return requestService.updateRequest(request);
    }

    @PUT
    @Path("/edit/{reqID}") /*Update for available device and save in device table*/
        public Edit_Mode editDetails(@PathParam("reqID") int id, Edit_Mode edit_Mode) {
        edit_Mode.setRequest_ID(id);
        return requestService.editDetails(edit_Mode);
    }

    @DELETE
        @Path("/{reqID}")
        public String deleteRequest(@PathParam("reqID") int id) {/*Add new request to the device table*/
        System.out.println("/request delete call");
        return requestService.deleteRequest(id);
    }
}
