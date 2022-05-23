import './App.css';
import Button from './components/Button'
import { Link } from "react-router-dom";

function App() {

  return (
    <>
      <div className='options'>
        <h1>Main menu</h1>
        <div className='container'>
          <Link to={`/Clients`}>
            <Button color='green' text='List Clients' />
          </Link>
        </div>

        <div className='container'>
          <Link to={`/Employees`}>
            <Button color='green' text='List Employees' />
          </Link>
        </div>
      </div>
    </>
  );
}
export default App;

//might wanna add a nav bar to ease the navigation