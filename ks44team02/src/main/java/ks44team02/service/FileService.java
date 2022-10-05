package ks44team02.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ks44team02.dto.FileDto;
import ks44team02.dto.GoodsInfoImage;
import ks44team02.dto.GoodsMainImage;
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

	public String goodsMainImageUpload(MultipartFile uploadfile, String fileRealPath, int isLocalhost) {
		
		GoodsMainImage goodsMainImage= fileUtil.parseGoodsMainImage(uploadfile, fileRealPath , isLocalhost);
		
		if(goodsMainImage != null) {
			fileMapper.addGoodsMainImage(goodsMainImage);
			String mainImageIdx = goodsMainImage.getMainImageIdx();
			return mainImageIdx;
		}
		return null;
	}
	public String goodsInfoImageUpload(MultipartFile uploadfile, String fileRealPath, int isLocalhost) {
		
		GoodsInfoImage goodsInfoImage = fileUtil.parseGoodsInfoImage(uploadfile, fileRealPath , isLocalhost);
		
		if(goodsInfoImage != null) {
			fileMapper.addGoodsInfoImage(goodsInfoImage);
			String infoImageIdx = goodsInfoImage.getInfoImageIdx();
			return infoImageIdx;
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
