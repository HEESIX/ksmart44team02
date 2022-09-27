package ks44team02.service;

import org.springframework.stereotype.Service;

import ks44team02.mapper.DeliveryInfoMapper;

@Service
public class DeliveryInfoService {

	private final DeliveryInfoMapper deliveryInfoMapper;
	
	public DeliveryInfoService(DeliveryInfoMapper deliveryInfoMapper) {
		this.deliveryInfoMapper = deliveryInfoMapper;
	}
}
