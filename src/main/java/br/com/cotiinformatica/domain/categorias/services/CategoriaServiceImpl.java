package br.com.cotiinformatica.domain.categorias.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.categorias.models.dtos.CategoriaRequest;
import br.com.cotiinformatica.domain.categorias.models.dtos.CategoriaResponse;
import br.com.cotiinformatica.domain.categorias.models.entities.Categoria;
import br.com.cotiinformatica.infrastructure.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoriaResponse criar(CategoriaRequest request) throws Exception {

		Categoria categoria = modelMapper.map(request, Categoria.class);

		categoriaRepository.save(categoria);

		CategoriaResponse response = modelMapper.map(categoria, CategoriaResponse.class);
		return response;
	}

	@Override
	public CategoriaResponse alterar(Integer id, CategoriaRequest request) throws Exception {

		Categoria categoria = categoriaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada."));

		categoria.setNome(request.getNome());

		categoriaRepository.save(categoria);

		CategoriaResponse response = modelMapper.map(categoria, CategoriaResponse.class);
		return response;
	}

	@Override
	public CategoriaResponse excluir(Integer id) throws Exception {

		Categoria categoria = categoriaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada."));

		categoriaRepository.delete(categoria);

		CategoriaResponse response = modelMapper.map(categoria, CategoriaResponse.class);
		return response;
	}

	@Override
	public List<CategoriaResponse> consultar() throws Exception {

		List<Categoria> categorias = categoriaRepository.findAll();

		List<CategoriaResponse> lista = new ArrayList<CategoriaResponse>();

		for (Categoria categoria : categorias) {
			CategoriaResponse response = modelMapper.map(categoria, CategoriaResponse.class);
			lista.add(response);
		}

		return lista;
	}

	@Override
	public CategoriaResponse obterPorId(Integer id) throws Exception {

		Categoria categoria = categoriaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada."));

		CategoriaResponse response = modelMapper.map(categoria, CategoriaResponse.class);
		return response;
	}

}
