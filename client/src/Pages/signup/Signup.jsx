import React, {useRef} from "react";
import "./signup.css";
import { Link } from "react-router-dom";
import axios from 'axios';
import {useNavigate} from 'react-router-dom';



const Signup = () => {
  const email = useRef();
  const password = useRef();
  const username = useRef();
  const navigate = useNavigate();

  const submitHandler = async(e) => {
     e.preventDefault();
     const user = {
       name : username.current.value,
       email : email.current.value,
       password : password.current.value,
     }
     try {
      const res = await axios.post("http://localhost:8080/register", user);
      if(res.data.status === "success") navigate("/login");
      else window.alert(res.data.status);
    } catch (err) {
      console.log(err);
    }
  }
  return (
    <>
      <div className="signup">
        <div className="logoText1">Spring Boot App</div>
        <div className="signupBox">

          <form onSubmit={submitHandler} className="form">
          <div className="inputContainer">
              <label  className="label">
                Name
              </label>
              <input type="text" className="input" ref={username} />
            </div>

            <div className="inputContainer">
              <label  className="label">
                Email
              </label>
              <input type="email" className="input" ref={email} />
            </div>

            <div className="inputContainer">
              <label className="label">
                Password
              </label>
              <input type="password" className="input" ref={password} />
            </div>

            <div className="agreeTerms">
              By clicking Agree & Join, you agree to the Commune{" "}
              <span className="iink">User Agreement</span>,
              <span className="iink">Privacy Policy</span>, and{" "}
              <span className="iink">Cookie Policy</span>.
            </div>

            <input type="submit" className="submitBtn1" value="Agree & Join" />
          </form>

          <div className="loginDirect">
          Have an account?&nbsp;<Link to='/login' className="iink">Sign in</Link>
          </div>
        </div>
      </div>
    </>
  );
};

export default Signup;
