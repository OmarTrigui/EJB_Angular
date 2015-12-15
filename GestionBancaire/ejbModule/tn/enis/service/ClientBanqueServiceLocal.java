package tn.enis.service;

import java.util.List;

import javax.ejb.Local;

import com.enis.dto.ClientBanqueDTO;

@Local
public interface ClientBanqueServiceLocal {

	public void ajoutClientBanque(ClientBanqueDTO clientBanqueDTO);

	public void supprimerClientBanque(ClientBanqueDTO clientBanqueDTO);

	public List<ClientBanqueDTO> getAllClientBanque();

	public ClientBanqueDTO getClientByCin(String cin);

}
