package com.azurita.azuritaweb.Config;

import com.azurita.azuritaweb.DTO.ProductDTO;
import com.azurita.azuritaweb.Entity.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<Product, ProductDTO> productMap = new PropertyMap<Product, ProductDTO>() {
            @Override
            protected void configure() {
                map().setProductId(source.getProductId().getProductId());
                map().setSize(source.getProductId().getSize());
            }
        };
        modelMapper.addMappings(productMap);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }

}
