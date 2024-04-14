import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    token : null,
    user : null
};

export const authSlice = createSlice({
    name : "auth",
    initialState,
    reducers : {
        setLogin : (state, action)=>{
            state.userName = action.payload.userName;
            state.token = action.payload.token;
        },
        setLogout : (state)=>{
            state.userName = null;
            state.token = null;
        }
    }
})

export const {setLogin, setLogout} = authSlice.actions; 
export default authSlice.reducer;