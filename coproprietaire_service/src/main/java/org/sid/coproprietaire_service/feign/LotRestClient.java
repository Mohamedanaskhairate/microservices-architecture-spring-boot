package org.sid.coproprietaire_service.feign;

import org.sid.coproprietaire_service.model.Lot;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value ="Lot-Service" , url="http://localhost:8083/lots" )
public interface LotRestClient {
    @GetMapping(path = "/{id}")
    Lot getLotById(@PathVariable(name = "id") Long id);
}
