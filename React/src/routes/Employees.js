import Button from '../../src/components/Button';
import { Link } from "react-router-dom";
import '../App.css';



export default function employees() {
    return (
        <>
            <div className='options'>
                <h2>pdv employé</h2>

                <Link to={`/ClientsWLogin`}>
                    <Button color='green' text='List of Clients' />
                </Link>

                <Link to={`/DocumentsForEmployee`}>
                    <Button color='green' text='Tout Les Documents' />
                </Link>

                <Link to={`/CreateBook`}>
                    <Button color='green' text='Crée un Livre' />
                </Link>

                <Link to={`/CreateDvd`}>
                    <Button color='green' text='Crée un Dvd' />
                </Link>

                <Link to={`/CreateCd`}>
                    <Button color='green' text='Crée un Cd' />
                </Link>


            </div>
        </>

    );
}