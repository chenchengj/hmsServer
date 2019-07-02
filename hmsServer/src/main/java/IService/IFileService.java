package IService;

import java.io.DataInputStream;

public interface IFileService {

	String upload(DataInputStream dis, String fileName, String fileType);

}
