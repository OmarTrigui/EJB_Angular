package common.helper;

import java.util.ArrayList;
import java.util.List;

import com.enis.dto.ClientBanqueDTO;

import tn.enis.model.ClientBanqueEntity;

public class ClientHelper {

	public static ClientBanqueEntity dtoToModel(ClientBanqueDTO cDTO) {
		return new ClientBanqueEntity(cDTO.getCin(), cDTO.getNomClient(),
				cDTO.getPrenomClient(), cDTO.getAdresse());
	}

	public static ClientBanqueDTO modelToDTO(ClientBanqueEntity c) {

		if (c == null)
			return null;

		return new ClientBanqueDTO(c.getCin(), c.getNom(), c.getPrenom(),
				c.getAdresse());
	}

	public static List<ClientBanqueDTO> modelListToDTOList(
			List<ClientBanqueEntity> listE) {
		if (listE == null)
			return null;
		List<ClientBanqueDTO> list = new ArrayList<ClientBanqueDTO>();
		for (ClientBanqueEntity cl : listE) {
			list.add(modelToDTO(cl));
		}
		return list;
	}

	public static List<ClientBanqueEntity> dtoListToModelList(
			List<ClientBanqueDTO> listDTO) {
		if (listDTO == null)
			return null;
		List<ClientBanqueEntity> list = new ArrayList<ClientBanqueEntity>();
		for (ClientBanqueDTO cl : listDTO) {
			list.add(dtoToModel(cl));
		}
		return list;
	}
}
