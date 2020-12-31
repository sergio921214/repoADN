package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import com.ceiba.auto.servicio.ServicioCrearAuto;
import com.ceiba.rentarauto.servicio.ServicioGuardarRentaAuto;
import com.ceiba.rentarauto.puerto.repositorio.RepositorioRentarAuto;
import com.ceiba.rentarauto.servicio.ServicioCalcularRentaAuto;
import com.ceiba.auto.servicio.ServicioRentarAuto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearAuto servicioCrearAuto(RepositorioAuto repositorioAuto) {
		return new ServicioCrearAuto(repositorioAuto);
	}

	@Bean
	public ServicioRentarAuto servicioRentarAuto(RepositorioAuto repositorioAuto) {
		return new ServicioRentarAuto(repositorioAuto);
	}

	@Bean
	public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioCrearUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioEliminarUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioActualizarUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioCalcularRentaAuto servicioSolicitarRentarAuto(RepositorioAuto repositorioAuto) {
		return new ServicioCalcularRentaAuto(repositorioAuto);
	}

	@Bean
	public ServicioGuardarRentaAuto servicioGuardarRentaAuto(RepositorioRentarAuto repositorioRentarAuto,
			RepositorioAuto repositorioAuto) {
		return new ServicioGuardarRentaAuto(repositorioRentarAuto, repositorioAuto);
	}

}
