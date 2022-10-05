package ks44team02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks44team02.dto.FileDto;
import ks44team02.dto.GoodsInfoImage;
import ks44team02.dto.GoodsMainImage;

@Mapper
public interface FileMapper {
	
	public int addGoodsMainImage(GoodsMainImage goodsMainImage); 
	
	public int addGoodsInfoImage(GoodsInfoImage goodsInfoImage);
	
	public List<FileDto> getFileList(boolean fileIsLocal);
	
	public FileDto getFileInfoByIdx(String fileIdx, boolean fileIsLocal);

}
