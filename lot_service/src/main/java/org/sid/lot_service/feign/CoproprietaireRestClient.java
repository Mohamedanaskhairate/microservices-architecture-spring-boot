package org.sid.lot_service.feign;
import org.sid.lot_service.model.Coproprietaire;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "Coproprietaire-Service",url="http://localhost:8082/coproprietaires")
public interface CoproprietaireRestClient {
    @GetMapping(path = "/{id}")
   Coproprietaire getCoproprietaireById(@PathVariable(name = "id") Long id);
}
