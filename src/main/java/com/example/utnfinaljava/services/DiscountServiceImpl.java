package com.example.utnfinaljava.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.utnfinaljava.config.mappers.DiscountMapper;
import com.example.utnfinaljava.dtos.DiscountDto;
import com.example.utnfinaljava.entities.Discount;
import com.example.utnfinaljava.interfaces.DiscountService;
import com.example.utnfinaljava.repositories.DiscountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiscountServiceImpl implements DiscountService  {

    private final DiscountRepository discountRepository;

    private final DiscountMapper discountMapper;

    @Override
    public List<DiscountDto> getTodayDiscount() {
        LocalDate currentDate = LocalDate.now();
        List<Discount> vigentDiscounts = new ArrayList<Discount>();
        List<Discount> discountsReversed = this.discountRepository.findAll();
        Collections.sort(discountsReversed, Collections.reverseOrder());
        for (Discount discounts : discountsReversed ) {
            LocalDate fromDate = discounts.getId().getValidityDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (fromDate.isBefore(currentDate) || fromDate.equals(currentDate)) {    
                    vigentDiscounts.add(discounts);
            }
        }
        List<DiscountDto> dtos = new ArrayList<DiscountDto>();
        for (Discount discount : vigentDiscounts) {
            DiscountDto dto = new DiscountDto();
            dto.setDiscount(discount.getDiscount());
            dto.setValidityDate(discount.getId().getValidityDate());
            dto.setAmountPrice(discount.getId().getAmountPrice());
            dtos.add(dto);
        }
        return dtos;
    }

	@Override
	public List<DiscountDto> getDiscounts() {
		List<Discount> discounts = discountRepository.findAll();
        List<DiscountDto> dtos = discountMapper.discountListToDiscountListDto(discounts);
        return dtos;
	}

	@Override
	public DiscountDto create(DiscountDto discount) {
		Discount entity = this.discountMapper.discountDtoToDiscount(discount);
        Discount saved = this.discountRepository.save(entity);
        return this.discountMapper.discountToDiscountDto(saved);
	}
    
}
