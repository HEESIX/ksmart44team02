package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ks44team02.dto.FileDto;
import ks44team02.mapper.FileMapper;
import ks44team02.util.FileUtil;

@Service
@Transactional
public class FileService {
	
	private FileUtil fileUtil;
	private FileMapper fileMapper;	
	
	public FileService(FileUtil fileUtil, FileMapper fileMapper) {
		
		this.fileUtil = fileUtil;
		this.fileMapper = fileMapper;
	}

	public String fileUpload(MultipartFile uploadfile, String fileRealPath, boolean isLocalhost) {
		
		FileDto fileInfo= fileUtil.parseFileInfo(uploadfile, fileRealPath , isLocalhost);
		
		if(fileInfo != null) {
			fileMapper.addFile(fileInfo);
			String fileIdx = fileInfo.getFileIdx();
			return fileIdx;
		}
		return null;
	}
	
	public List<FileDto> getFileList(boolean fileIsLocal){
		return fileMapper.getFileList(fileIsLocal);
	}
	
	public FileDto getFileInfoByIdx(String fileIdx, boolean fileIsLocal) {
		return fileMapper.getFileInfoByIdx(fileIdx, fileIsLocal);
	}

}
