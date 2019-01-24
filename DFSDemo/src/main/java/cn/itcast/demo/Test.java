package cn.itcast.demo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
//		1、加载配置文件，配置文件的内容就是他racket服务
		ClientGlobal.init("E:\\SSH\\workspace_pingyougou\\DFSDemo\\src\\main\\resources\\fdfs_client.conf");
//		2、创建client对象，
		TrackerClient trackerClient = new TrackerClient();
//		创建track Clinetservice服务
		TrackerServer trackerServer  = trackerClient.getConnection();
//		// 4、创建一个 StorageServer 的引用，值为 null
		StorageServer storageServer = null;
		
//		创建对象storangeClient对象，需要两个参数trackerClient、trackerServer
		StorageClient client = new StorageClient(trackerServer, storageServer);
		
//		上传图片
		String[] strings = client.upload_file("D:/upload/image\\01.gif", "gif", null);
		
//		遍历数组
		for(String str : strings) {
			System.out.println(str);
		}
	}
}
