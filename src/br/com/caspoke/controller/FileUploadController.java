package br.com.caspoke.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping("salvarImagemPeruca")
	public String salvaImagem(String link, MultipartFile foto, long id) {
		try {
			String filePath = "/Users/Caspoke/Documents/workspace/CaspokeWigs/WebContent/resources/imagens/perucas/" + id + ".jpg";
			System.out.println(filePath);
			
			//SALVANDO A IMAGEM A PARTIR DE UM LINK
			if (!link.equals(""))
			{
				URL url = new URL(link);
				InputStream is = new BufferedInputStream(url.openStream());
				byte[] bytes = IOUtils.toByteArray(is);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(bytes);
				stream.close();
				is.close();
				
			}
			
			//SALVANDO A IMAGEM A PARTIR DE UM UPLOAD
			else if (!foto.isEmpty())
			{
				if (foto.getContentType().startsWith("image"))
				{
					byte[] bytes = foto.getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
					stream.write(bytes);
					stream.close();
				}
				else{
					//lançar uma exceção sobre tipo de arquivo inválido
				}
			}
			
			else {
				//lançar uma exceção quando não houve upload nem link
			}
		}
		catch(Exception e) {
			return "redirect:listaPerucas";
		}
		
		return "redirect:listaPerucas";
	}
	
	@RequestMapping("salvarImagemVariasPerucas")
	public String salvaImagemVariasPerucas(String link, String id) {
		try {
			ArrayList<String> links = new ArrayList<String>(Arrays.asList(link.split("\\s*,\\s*")));
			ArrayList<String> ids = new ArrayList<String>(Arrays.asList(id.split("\\s*,\\s*")));
			System.out.println("String de ids: " + id);
			System.out.println("Quantidade de links: " + links.size());
			
			for (int i = 0; i < ids.size(); i++)
				{
				String filePath = "/Users/Caspoke/Documents/workspace/CaspokeWigs/WebContent/resources/imagens/perucas/" + ids.get(i) + ".jpg";
				System.out.println(filePath);
				
				//SALVANDO A IMAGEM A PARTIR DE UM LINK
				if (!links.isEmpty()) 
				{
					URL url = new URL(links.get(i));
					InputStream is = new BufferedInputStream(url.openStream());
					byte[] bytes = IOUtils.toByteArray(is);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
					stream.write(bytes);
					stream.close();
					is.close();
					
				}
				
				else {
					
					System.out.println("Não houve upload para peruca de id " + ids.get(i));
					//lançar uma exceção quando não houve upload nem link
				}
			}
		}
		catch(Exception e) {
			return "redirect:listaPerucas";
		}
		
		return "redirect:listaPerucas";
	}
}
