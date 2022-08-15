import { createSlice } from "@reduxjs/toolkit";

const initialStateValue = {
  user : JSON.parse(localStorage.getItem("user")) || null,
  token : ""
};

const userSlice = createSlice({
  name: "user",
  initialState: initialStateValue,
  reducers: {
    login : (state, action) => {
        return({
            ...state,
            user : action.payload.student,
            token : action.payload.jwttocken
        })
    }
  },
});

export const {
  login
} = userSlice.actions;
export default userSlice.reducer;
