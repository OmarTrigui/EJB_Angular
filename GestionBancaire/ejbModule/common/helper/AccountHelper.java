package common.helper;

import java.util.ArrayList;
import java.util.List;

import tn.enis.model.CompteBancaireEntity;

import com.enis.dto.CompteBancaireDTO;

public class AccountHelper {

	public static CompteBancaireDTO modelToDTO(CompteBancaireEntity c) {
		return new CompteBancaireDTO(c.getRib(),c.getSolde(), ClientHelper.modelToDTO(c
				.getClient()));
	}

	public static List<CompteBancaireDTO> modelListToDTOList(
			List<CompteBancaireEntity> listE) {
		if (listE == null)
			return null;

		List<CompteBancaireDTO> list = new ArrayList<CompteBancaireDTO>();
		for (CompteBancaireEntity cl : listE) {
			list.add(modelToDTO(cl));
		}
		return list;
	}
}
