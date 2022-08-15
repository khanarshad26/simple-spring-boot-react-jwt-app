import React, { useRef } from "react";
import "./signin.css";
import { Link } from "react-router-dom";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import {login} from '../../state/user.js';

const Signin = () => {

  const dispatch = useDispatch();
  const navigate = useNavigate();

  const email = useRef();
  const password = useRef();

  const SigninHandler = async (e) => {
    e.preventDefault();
    const user = {
      email : email.current.value,
      password : password.current.value,
    }
    try {
     const res = await axios.post("http://localhost:8080/login", user);
     console.log("token : ",res.data);
     if(res.data.status === "success"){
       dispatch(login({
         student : res.data.student,
         jwttocken : res.data.jwttocken
       }));
       navigate("/");
     }else{
       window.alert(res.data.status);
     }
   } catch (err) {
     console.log(err);
   }
  };

  return (
    <>
      <div className="signin">
        <div className="logoText2">Spring Boot App</div>
        <div className="signupBox">
          <form onSubmit={SigninHandler} className="form">
            <div className="inputContainer">
              <label className="label">
                Email
              </label>
              <input type="email" className="input" ref={email} />
            </div>

            <div className="inputContainer">
              <label className="label">
                Password
              </label>
              <input type="password" className="input" ref={password} />
              <div className="forgotPassword">

                <span className="iink" style={{ fontSize: '12px' }} >Forgot Password?</span>
              </div>
            </div>



            <input type="submit" className="submitBtn" value="Sign in" />
          </form>
          <hr className='hr' />

          <div className="loginDirect">
            New Here?&nbsp;<Link to='/register' className="iink">Join now</Link>
          </div>
        </div>
      </div>
    </>
  );
};

export default Signin;
