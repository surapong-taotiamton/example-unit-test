package blog.surapong.example.unit_test.realwork.rawdesign;


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

		ftpDownloadTask.run();
		
		////////////
		// ASSERT
		////////////
		
		// How to assert ?

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

		ftpDownloadTask.run();
		
		////////////
		// ASSERT
		////////////
		
		// How to assert ?

	}
	
}
