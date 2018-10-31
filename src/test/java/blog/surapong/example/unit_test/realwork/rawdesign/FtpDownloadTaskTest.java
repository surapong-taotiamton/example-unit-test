package blog.surapong.example.unit_test.realwork.rawdesign;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FtpDownloadTaskTest {
	
	@Test
	public void run_NormalCase_NoIdeaToVerify() throws Exception {
		
		
		/////////////
		// ARRANGE
		////////////
		
		FtpDownloadTask ftpDownloadTask = new FtpDownloadTask();
		
		////////////
		// ACT
		///////////
		
		ftpDownloadTask.run();

		////////////
		// ASSERT
		////////////

		// How to assert ?
		
	}
	
	@Test
	public void run_FtpConnectionError_ThrowIOException() throws Exception {
		
		
		/////////////
		// ARRANGE
		////////////
		
		FtpDownloadTask ftpDownloadTask = new FtpDownloadTask();

		////////////
		// ACT
		///////////

		////////////
		// ASSERT
		////////////
		
		assertThrows(IOException.class, () -> {
			ftpDownloadTask.run();
		});

	}
	
	@Test
	public void run_FtpListFileError_ThrowIOException() throws Exception {
		
		
		/////////////
		// ARRANGE
		////////////

		FtpDownloadTask ftpDownloadTask = new FtpDownloadTask();
		
		////////////
		// ACT
		///////////

		////////////
		// ASSERT
		////////////
		
		assertThrows(IOException.class, () -> {
			ftpDownloadTask.run();
		});

	}
	
}
