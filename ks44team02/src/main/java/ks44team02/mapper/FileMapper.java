package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.FileDto;

@Mapper
public interface FileMapper {
	
	public int addFile(FileDto fileList); 
	
	public List<FileDto> getFileList(boolean fileIsLocal);
	
	public FileDto getFileInfoByIdx(String fileIdx, boolean fileIsLocal);

}
