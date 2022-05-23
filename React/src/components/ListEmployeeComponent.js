import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';
import { Link } from "react-router-dom";
import Button from './Button';


class ListEmployeeComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            employees: []
        }
    }

    componentDidMount() {
        EmployeeService.getEmployees().then((res) => {
            this.setState({ employees: res.data });
        });
    }

    render() {
        return (
            <>
                <div className='options'>
                    <div class="container">
                        <h2>Employee List</h2>
                        <ul class="responsive-table">
                            <li class="table-header">
                                <div class="col col-1">Full Name</div>
                                <div class="col col-2">Email</div>
                                <div class="col col-3">Login</div>
                            </li>
                            <div>
                                {this.state.employees.map(
                                    employee => <li className='table-row' key={employee.id}>
                                        <div class="col col-1" > {employee.fullName} </div>
                                        <div class="col col-2" >{employee.email}</div>
                                        <div class="col col-3" >
                                            <Link to={`/Employee/${employee.id}`}>
                                                <Button color='green' text='Log in' />
                                            </Link>
                                        </div>
                                    </li>
                                )}
                            </div>
                        </ul>
                    </div>
                </div>
            </>
        )

    }
}

export default ListEmployeeComponent