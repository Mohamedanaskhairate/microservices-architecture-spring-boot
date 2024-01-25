package org.sig.mandat_service.feign;

import org.sig.mandat_service.model.Copropriete;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value ="Copropriete-Service" , url="http://localhost:8081/coproprietes" )
public interface CoproprieteRestClient {
    @GetMapping(path = "/{id}")
    Copropriete getCoproprieteById(@PathVariable(name = "id") Long id);
}
