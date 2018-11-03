package blog.surapong.example.unit_test.realwork.rawdesign;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FtpDownloadTask implements Runnable {
	
	@Override
	public void run() {
		
		String serverDir = "serverDir";
		String localDir = "localDir";

		try {
			connect();
		} catch (IOException ex) {
			return;
		}
		List<String> listFile = null;
		try {
			listFile = getListFile(serverDir);
		} catch (IOException e) {
			disconnect();
			return;
		}
		
		for (String fileName : listFile) {
			
			InputStream inputStream;
			try {
				inputStream = downloadFile(serverDir, fileName);
				saveFileToLocal(inputStream, localDir, fileName);
				cleanupFileInServer(serverDir, fileName);
			} catch (IOException e) {
				continue;
			}
		}
		
		disconnect();
	}

	private void connect() throws IOException {
		// Assume get connection
	}
	
	private List<String> getListFile(String directoryName) throws IOException {
		// Assume return all fileName from server
		return new ArrayList<String>();
	}
	
	private InputStream downloadFile(String dirName, String fileName) throws IOException {
		// Assume download file from server to input stream
		return new ByteArrayInputStream(null);
	}
	
	private void saveFileToLocal(InputStream inputStream, String localDir, String fileName) throws IOException {
		// Assume save file to local Server
	}
	
	private void cleanupFileInServer(String serverDir, String fileName) throws IOException {
		// Assume cleanup file from server
	}
	
	private void disconnect() {
		//  Assume disconnect server
	}

}
