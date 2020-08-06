package com.supermercado.event;


import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

import com.supermercado.domain.Cliente;
import com.supermercado.service.SequenceGeneratorService;

@Component
public class ClienteModelListener extends AbstractMongoEventListener<Cliente> {
	
	
	private SequenceGeneratorService sequenceGenerator;
	
	public ClienteModelListener(SequenceGeneratorService sequenceGeneratorService) {
		this.sequenceGenerator = sequenceGeneratorService;
	}
	
	@Override
    public void onBeforeConvert(BeforeConvertEvent<Cliente> event) {
        if (event.getSource().getCodigo() == null) {
            event.getSource().setCodigo(sequenceGenerator.generateSequence(Cliente.SEQUENCE_NAME));
        }
    }

}
