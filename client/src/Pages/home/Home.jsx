import React from 'react'
import './home.css'
import { useSelector } from 'react-redux'

const Home = () => {
  const token = useSelector(state => state.user.token);
  return (
    <div>Welcome Authrized user. You JWT Token is : {token}</div>
  )
}

export default Home