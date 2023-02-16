import { useContext } from 'react';
import { AppStateContext } from '../store/providers';

const useAppStateContext = () => {
  return useContext(AppStateContext);
};

export default useAppStateContext;
