package com.zeal.scheduled;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zeal.dao.*;
import com.zeal.entity.DiyPercent;
import com.zeal.entity.GeneralPercent;
import com.zeal.entity.MatchAttribute;
import com.zeal.entity.PersonAttribute;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ScheduledController {
	@Autowired
	private GeneralPercentDao generalPercentDao;

	@Autowired
	private PersonAttributeDao personAttributeDao;

	@Autowired
	private DiyPercentDao diyPercentDao;

	@Autowired
	private MatchAttributeDao matchAttributeDao;


	//更新通用数据占比
	@Scheduled(cron="0 0 0/4 * * ?")
//	@Scheduled(cron="* 0/5 * * * ? ")
	public void updateProportion() throws IllegalAccessException {
		updateBySex(0);
		updateBySex(1);
	}

	private void updateBySex(int sex) throws IllegalAccessException {
		List<PersonAttribute> femaleData = personAttributeDao.selectList(new QueryWrapper<PersonAttribute>().eq("sex", sex));
		List<DiyPercent> femaleDataDIY = diyPercentDao.selectList(new QueryWrapper<DiyPercent>().eq("matchSex", sex));
		GeneralPercent generalPercent = new GeneralPercent();
		Field[] fields = PersonAttribute.class.getDeclaredFields();
		for(Field field : fields){
			PersonAttribute attribute = new PersonAttribute();
			List<Double> ageList = new ArrayList<>();
			for(PersonAttribute personAttribute : femaleData){
				double value = (double) field.get(personAttribute);
				ageList.add(value);
			}
			List<Double> ageListDIY = new ArrayList<>();
			for(DiyPercent diyPercent : femaleDataDIY){
				double value = (double) field.get(diyPercent);
				ageListDIY.add(value);
			}
//		List<Double> ageList = femaleData.stream().map(PersonAttribute::getAge).collect(Collectors.toList());
//		List<Double> ageListDIY = femaleDataDIY.stream().map(DiyPercent::getAge).collect(Collectors.toList());
			double rate = ageListDIY.stream().mapToDouble(Double::doubleValue).sum() / ageListDIY.size();
			//获取所有占比
			generalPercent.setRateInAll(rate);
			List<Double> ages = ageList.stream().distinct().collect(Collectors.toList());
//		List<Integer> agesDIY = ageListDIY.stream().distinct().collect(Collectors.toList());
			double value = (double) field.get(attribute);
			String name = (String) field.get(attribute);
			for(double age : ages){
				long count = ageList.stream().filter(integer -> Objects.equals(integer, age)).count();
				long countDIY = ageListDIY.stream().filter(integer -> Objects.equals(integer, age)).count();
				generalPercent.setAttribute(name);
				generalPercent.setAttributeValue(age);
				double supply = ((double) count / ageList.size());
				double demand = ((double) countDIY / ageListDIY.size());
				//制定供给与需求
				generalPercent.setAttributeScore(getScoreBySupplyAndDemand(supply,demand));
				generalPercent.setAttributeProportion(supply);
				generalPercent.setDemandProportion(demand);
				GeneralPercent generalPercentDaoByNameAndValue = generalPercentDao.getByNameAndValue(name, String.valueOf(value),sex);
				if(generalPercentDaoByNameAndValue != null){
					generalPercentDao.update(generalPercent,new UpdateWrapper<GeneralPercent>().eq("name",name).eq("value",value));
				}else{
					generalPercentDao.insert(generalPercent);
				}
			}
		}
	}

	public double getScoreBySupplyAndDemand(double supply,double demand){
		double val = demand / supply;
//		需求量越大 val越大 分数越高
		return  Double.parseDouble(String.format("%.2f",val / (val + 1) * 100));
	}


	@Test
	public void  test(){
		double val = 200;
		System.out.println(String.format("%.2f",val / (val + 1) * 100));
	}



}
