import './App.css';
import Signin from './Pages/signin/Signin'
import Signup from './Pages/signup/Signup'
import LandingPage from './Pages/landingPage/LandingPage'
import Home from './Pages/home/Home'
import { useSelector } from 'react-redux';
import {
  Route,
  Routes,
  BrowserRouter as Router,
  Navigate
} from 'react-router-dom'

function App() {
  const user = useSelector(state => state.user.user);
 console.log(user);
  return (
    <Router>
      <Routes>
        <Route exact path = "/" element = {user? <Home/> : <LandingPage/>} ></Route>
        <Route exact path = "/register" element = {user? <Navigate to='/' /> : <Signup/>} ></Route>
        <Route exact path = "/login" element = {user? <Navigate to='/' /> : <Signin/>} ></Route>
        {/* <Route exact path = "/welcome" element = {<Home/>} ></Route> */}
      </Routes>
    </Router>
  );
}

export default App;
