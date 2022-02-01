package com.project.hms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hms.entity.Bill;
import com.project.hms.repository.BillRepository;
import com.project.hms.service.BillService;


@Service
public class BillServiceImpl implements BillService {

	private BillRepository billRepository;

	public BillServiceImpl(BillRepository billRepository) {
		super();
		this.billRepository = billRepository;
	}

	@Override
	public List<Bill> getAllBills() {
		// TODO Auto-generated method stub
		return billRepository.findAll();
	}

	@Override
	public Bill saveBill(Bill bill) {
		// TODO Auto-generated method stub
		return billRepository.save(bill);
	}

	@Override
	public Bill getBillById(Integer id) {
		// TODO Auto-generated method stub
		return billRepository.findById(id).get();
	}

	@Override
	public Bill updateBill(Bill bill) {
		// TODO Auto-generated method stub
		return billRepository.save(bill);
	}

	@Override
	public void deleteBillById(Integer id) {
		// TODO Auto-generated method stub
		billRepository.deleteById(id);
	}

	

}
