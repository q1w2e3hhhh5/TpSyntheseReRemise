import React, { Component } from 'react';
import Button from '../Button';
import { Link } from "react-router-dom";
import EmployeeService from '../../services/EmployeeService';
import '../../App.css';

class CreateClient extends Component {
    constructor(props) {
        super(props)

        this.state = {
            fullName: "",
            email: "",
            password: ""
        }

        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeFullNameHandler = this.changeFullNameHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.saveClient = this.saveClient.bind(this);
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

    saveClient = (e) => {
        e.preventDefault();
        let client = { fullName: this.state.fullName, email: this.state.email, password: this.state.password };
        console.log("client=>" + JSON.stringify(client))

        EmployeeService.createClient(client).then(res => {
            this.props.history.push("/Clients");
        });

        alert("User has been created")

    }

    render() {
        return (
            <div className='options'>
                <div className='container'>
                    <div>
                        <h3>Add Client</h3>
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
                        <Button color='green' text='Save' onClick={this.saveClient} />
                        <Link to={`/`}><Button color='red' text='Anuller' /></Link>

                    </div>
                </div >
            </div >
        )
    }
}
export default CreateClient