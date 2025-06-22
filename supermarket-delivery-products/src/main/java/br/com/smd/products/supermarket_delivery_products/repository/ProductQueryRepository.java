package br.com.smd.products.supermarket_delivery_products.repository;

import br.com.smd.products.supermarket_delivery_products.domain.Product;
import br.com.smd.products.supermarket_delivery_products.dto.request.SearchProductQueryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductQueryRepository {

    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String BRAND = "brand";
    private static final String IN_STOCK = "inStock";
    private static final String DELETED = "deleted";

    private final MongoTemplate mongoTemplate;

    public List<Product> searchProduct(SearchProductQueryRequest request) {
        Criteria criteria = Criteria.where(DELETED).is(false);

        Optional.ofNullable(request.productsId()).ifPresent(list -> {
            if (!list.isEmpty()) {
                criteria.and(ID).in(list);
            }
        });

        Optional.ofNullable(request.name())
                .ifPresent(n -> criteria.and(NAME).is(n));

        Optional.ofNullable(request.brand())
                .ifPresent(b -> criteria.and(BRAND).is(b));

        Optional.ofNullable(request.inStock())
                .ifPresent(s -> criteria.and(IN_STOCK).is(s));

        Optional.ofNullable(request.inStock())
                .ifPresent(s -> criteria.and(IN_STOCK).is(s));

        String sorting = Optional.ofNullable(request.sort())
                .orElse("name");

        String ordering = Optional.ofNullable(request.order())
                .orElse("DESC");

        PageRequest pageRequest = PageRequest.of(
                request.page(),
                request.size() == 0 ? 100 : request.size(),
                Sort.Direction.fromString(ordering),
                sorting
        );

        Query query = new Query(criteria).with(pageRequest);

        log.info("Querying: [{}]", query);

        return mongoTemplate.find(query, Product.class);
    }
}
