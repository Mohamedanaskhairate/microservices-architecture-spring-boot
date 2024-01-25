package org.sid.lot_service.feign;
import org.sid.lot_service.model.Copropriete;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(value ="Copropriete-Service" , url="http://localhost:8081/coproprietes" )
public interface CoproprieteRestClient {

    @GetMapping(path = "/{id}")
    Copropriete getCoproprieteById(@PathVariable(name = "id") Long id);
}
