package tw.gov.nca.gss.common.util;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import tw.gov.nca.gss.common.GssBusinessException;
import tw.gov.nca.gss.common.GssMessage;

public class AddFolderToZip {

	public static void main(String[] args) {
		try {
			new AddFolderToZip();
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

 // 
	public AddFolderToZip() throws ZipException {
		try {
			ZipFile zipFile = new ZipFile("C:/Users/JamesHuang/Desktop/try.zip");
			String folderToAdd = "C:/Users/JamesHuang/Desktop/backups";
			// ZipFile zipFile = new ZipFile(path);
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

			parameters.setEncryptFiles(true);
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
			parameters.setPassword("123");
			zipFile.addFolder(folderToAdd, parameters);
		} catch (Exception e) {
			throw new GssBusinessException(GssMessage.G000AE, e);
		}
	}

	public AddFolderToZip(final String path, final String folderToAdd, final String pwd) throws ZipException {
		try {
			ZipFile zipFile = new ZipFile(path);
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

			parameters.setEncryptFiles(true);
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
			parameters.setPassword(pwd);
			zipFile.addFolder(folderToAdd, parameters);
		} catch (Exception e) {
			throw new GssBusinessException(GssMessage.G000AE, e);
		}
	}
}