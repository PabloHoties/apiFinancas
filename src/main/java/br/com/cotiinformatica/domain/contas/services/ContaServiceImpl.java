package br.com.cotiinformatica.domain.contas.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.categorias.models.entities.Categoria;
import br.com.cotiinformatica.domain.contas.models.dtos.ContaRequest;
import br.com.cotiinformatica.domain.contas.models.dtos.ContaResponse;
import br.com.cotiinformatica.domain.contas.models.entities.Conta;
import br.com.cotiinformatica.infrastructure.repositories.CategoriaRepository;
import br.com.cotiinformatica.infrastructure.repositories.ContaRepository;

@Service
public class ContaServiceImpl implements ContaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ContaResponse criar(ContaRequest request) throws Exception {
		
		Categoria categoria = categoriaRepository.findById(request.getCategoriaId())
				.orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada."));
		
		Conta conta = modelMapper.map(request, Conta.class);
		conta.setCategoria(categoria);
		
		contaRepository.save(conta);
		
		ContaResponse response = modelMapper.map(conta, ContaResponse.class);
		return response;
	}

	@Override
	public ContaResponse alterar(Integer id, ContaRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContaResponse excluir(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaResponse> consultar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContaResponse obterPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
