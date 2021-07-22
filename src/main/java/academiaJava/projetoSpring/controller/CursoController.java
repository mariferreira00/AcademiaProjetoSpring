package academiaJava.projetoSpring.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academiaJava.projetoSpring.Repository.CursoRepository;
import academiaJava.projetoSpring.model.Aluno;
import academiaJava.projetoSpring.model.Curso;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@PostMapping("/post")
	public Curso criarCurso(@Valid @RequestBody Curso curso){
		
		return this.cursoRepository.save(curso);

	}
	
	@GetMapping("/get")
	public List<Curso> getCurso() {
		return this.cursoRepository.findAll();
	}
	
	@GetMapping("/get/{id}")
    public Optional<Curso> getCursos(@PathVariable("id") int id) {
		return this.cursoRepository.findById(id);
    	}
    
	@PutMapping("/update/{id}")
	public String attCurso(@RequestBody Curso cursoN, @PathVariable("id") int id) {
		
		Optional<Curso> cursoAnt = this.cursoRepository.findById(id);
		if (cursoAnt.isPresent()) {
			cursoRepository.delete(cursoAnt.get());
			Curso curso = cursoAnt.get();
			curso.setNome(cursoN.getNome());
			curso.setCod(cursoN.getCod());
			cursoRepository.save(curso);
			
			return "Os dados do curso foram alterados com sucesso!";
		}else {
			return "Ops... Não encontramos nenhum curso com este id em nosso sistema, tente novamente!";
		}
	}

	
	
	@DeleteMapping("/delete/{id}")
	public  String apagarCurso(@PathVariable("id") int id) {
		
		Optional<Curso> cursoEncontrado = this.cursoRepository.findById(id);
		
		if (cursoEncontrado.isPresent()) {
			cursoRepository.delete(cursoEncontrado.get());
			
			return "O curso selecionado foi excluído com sucesso!";
		}else {
			
			return "Ops... Não encontramos nenhum curso com este id em nosso sistema, tente novamente!";
		}
		
	}
	


}
