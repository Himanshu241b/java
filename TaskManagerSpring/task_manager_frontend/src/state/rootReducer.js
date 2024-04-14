

import { combineReducers } from '@reduxjs/toolkit';
// Import more reducers
import authReducer from './index';

const rootReducer = combineReducers({
    auth: authReducer,
    
  // Add more reducers as needed
});

export default rootReducer;
