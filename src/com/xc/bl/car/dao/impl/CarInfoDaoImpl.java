package com.xc.bl.car.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xc.bl.car.dao.ICarInfoDao;
import com.xc.bl.entities.Car;
import com.xc.bl.entities.dao.IBaseDAO;

@Repository("carInfoDao")
public class CarInfoDaoImpl implements ICarInfoDao {

	@Autowired
	private IBaseDAO<Car> baseDAO;

	@Override
	public void addCar(Car car) {
		baseDAO.save(car);
	}

	@Override
	public int updCarInfoById(Car car) {
		int updCount = 0;
		try {
			baseDAO.update(car);
			updCount = 1;
		} catch (Exception ex) {
			updCount = 0;
		}
		return updCount;

	}

	@Override
	public Car getCarById(long cid) {
		return baseDAO.get("from Car where carId=?", new Object[] { cid });
	}
}
