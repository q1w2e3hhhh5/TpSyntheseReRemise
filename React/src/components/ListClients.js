import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';
import '../App.css'
import Button from './Button';
import { Link } from "react-router-dom";

class ListClientComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            clients: []
        }

        this.editClient = this.editClient.bind(this);
    }


    editClient(id) {
        this.props.history.push(`/UpdateClient/${id}`)
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
                                <div class="col col-1">Nom complet</div>
                                <div class="col col-2">Courriels</div>
                                <div class="col col-2">Action</div>
                            </li>
                            <div>
                                {this.state.clients.map(
                                    client => <li className='table-row' key={client.id}>
                                        <div class="col col-1" > {client.fullName} </div>
                                        <div class="col col-2" >{client.email}</div>
                                        <div class="col col-3" >
                                            <Link to={`/Client/${client.id}`}>
                                                <Button color='green' text='Mettre à Jour' />
                                            </Link>


                                            <Link to={`/ListOfBorrows/${client.id}`}>
                                                <Button color='green' text='Emprunts' />
                                            </Link>
                                        </div>
                                    </li>
                                )}
                            </div>
                        </ul>
                    </div>
                    <Link to={`/CreateClient`}>
                        <Button color='green' text='Ajouter Un Client' onClick={this.addClient} />
                    </Link>

                </div>
            </>
        )
    }
}

export default ListClientComponent