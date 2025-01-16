package org.juandavyc.services;

import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import org.juandavyc.models.ProductX;

import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProductServiceImpl implements ProductService {

    private final Locale locale = Locale.forLanguageTag("es");
    private final Faker faker = new Faker(locale);
    private final Random random = new Random();


    @Override
    public ProductX createProduct() {
        var date = Faker.instance(new Random())
                .date()
                .future(1000, TimeUnit.DAYS)
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        var price = faker.commerce().price().replace(",",".");

        return new ProductX(
                random.nextBoolean() ? "Frutino" :   faker.commerce().productName(),
                faker.commerce().promotionCode(),
                faker.commerce().material(),
                date,
                Float.parseFloat(price)
        );
    }
}
