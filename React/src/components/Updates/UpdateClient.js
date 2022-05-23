import React, { Component } from 'react';
import Button from '../Button';
import { Link } from "react-router-dom";
import EmployeeService from '../../services/EmployeeService';
import '../../App.css';


class UpdateClient extends Component {

    constructor(props) {
        super(props)

        this.state = {
            id: window.location.href.split('/').pop(),
            fullName: "",
            email: "",
            password: ""
        }

        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeFullNameHandler = this.changeFullNameHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.updateClient = this.updateClient.bind(this);

    }

    componentDidMount() {
        EmployeeService.getClientById(window.location.href.split('/').pop()).then((res) => {
            let client = res.data;
            console.log("client=>" + JSON.stringify(client))
            this.setState({
                fullName: client.fullName,
                email: client.email,
                password: client.password
            });
        });

    }


    changeFullNameHandler = (event) => {
        this.setState({ fullName: event.target.value });
    }

    changeEmailHandler = (event) => {
        this.setState({ email: event.target.value });
    }

    changePasswordHandler = (event) => {
        this.setState({ password: event.target.value });
    }

    updateClient = (e) => {
        e.preventDefault();
        let client = { fullName: this.state.fullName, email: this.state.email, password: this.state.password };
        console.log("client=>" + JSON.stringify(client))

        EmployeeService.updateClient(client, this.state.id).then(res => {
            this.props.history.push("/Clients")
        })
        alert("Le client a été mis à jours");

    }

    render() {
        return (
            <div className='options'>
                <div className='container'>
                    <div>
                        <h3>Modifier Le Client</h3>
                        <form>
                            <div className='block'>
                                <label>Full name:</label>
                                <input placeholder='name' name='fullName'
                                    value={this.state.fullName} onChange={this.changeFullNameHandler} />
                            </div>
                            <div className='block'>
                                <label>Email:</label>
                                <input placeholder='email' name='email'
                                    value={this.state.email} onChange={this.changeEmailHandler} />
                            </div>
                            <div className='block'>
                                <label>Password:</label>
                                <input placeholder='***' name='password'
                                    value={this.state.password} onChange={this.changePasswordHandler} />
                            </div>
                        </form>
                        <Button color='green' text='Enregistrer' onClick={this.updateClient} />
                        <Link to={`/ClientsWLogin`}><Button color='red' text='Annuler' /></Link>
                    </div>
                </div >
            </div >
        )
    }


}




export default UpdateClient