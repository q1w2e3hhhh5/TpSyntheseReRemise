import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';
import { Link } from "react-router-dom";
import Button from './Button';
import '../App.css'

class ListClientComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            clients: []
        }
        this.addClient = this.addClient.bind(this);
    }

    addClient() {
        this.props.history.push(`/CreateClient`);
    }

    componentDidMount() {
        EmployeeService.getClients().then((res) => {
            this.setState({ clients: res.data });
        });
    }

    render() {
        return (
            <>
                <div className='options'>
                    <div class="container">
                        <h2>Clients List</h2>
                        <ul class="responsive-table">
                            <li class="table-header">
                                <div class="col col-1">Nom Complet</div>
                                <div class="col col-2">Courriels</div>
                                <div class="col col-3">Se Connecter</div>
                            </li>
                            <div>
                                {this.state.clients.map(
                                    client => <li className='table-row' key={client.id}>
                                        <div class="col col-1" > {client.fullName} </div>
                                        <div class="col col-2" >{client.email}</div>
                                        <div class="col col-3" >
                                            <Link to={`/ClientInterface/${client.id}`}>
                                                <Button color='green' text='Log in' />
                                            </Link>
                                        </div>
                                    </li>
                                )}
                            </div>
                        </ul>
                    </div>
                    <Link to={`/CreateClient`}>
                        <Button color='green' text='Inscrire' onClick={this.addClient} />
                    </Link>
                </div>
            </>

        )

    }

}


export default ListClientComponent