package com.eldoraludo.ppafgestion.testagarder;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.eldoraludo.ppafgestion.domain.Itemlieudedepot;
import com.eldoraludo.ppafgestion.repository.ItemlieudedepotRepository;

@Singleton
public class TestClasse {
	@Inject
	private ItemlieudedepotRepository itemlieudedepotRepository;

	public Itemlieudedepot newIfNull(Itemlieudedepot itemlieudedepot) {
		if (itemlieudedepot != null) {
			return itemlieudedepot;
		}

		return itemlieudedepotRepository.getNewWithDefaults();
	}
}
