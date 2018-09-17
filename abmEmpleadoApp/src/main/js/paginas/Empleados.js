import React from "react"
import Tablas from "../componentes/tablas/TablaEmpleado"
import Modal from "../componentes/modales/ModalCrearEmpleados"
import {connect} from "react-redux"
import {bindActionCreators} from "redux"

class Empleados extends React.Component{

	componentDidMount() {
		this.props.cambiarTitulo();
	} 
	render(){
		return(
			<div className='container tabla'>
				<h2 className="titulo">{this.props.titulo}</h2>
				<Modal/>
				<Tablas/>
			</div>

		)
	}
}

let cambiarTitulo=()=>{
	return{
		type:"CAMBIAR_TITULO"
		,payload:"Empleados"
		
	}

}


let unaCopiaDelStore=store=> {
	return{
		titulo:store.App.titulo
	}
}
let laFuncionDispatch=dispatch=> {
	return{
		cambiarTitulo:bindActionCreators(cambiarTitulo,dispatch)
	}
	
}

export default connect(unaCopiaDelStore,laFuncionDispatch)(Empleados)