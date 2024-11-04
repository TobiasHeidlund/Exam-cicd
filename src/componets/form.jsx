import React from 'react'
import '/form.css'
import axios from 'axios';

function form(typeOfAction) {

    const [formData, setFormData] = useState({
        String: '',
        Seed: '',
        Encrypt: '',
      });
    const [submitted, setSubmitted] = useState(false);
    const apiUrl = import.meta.env.VITE_BACKENDURL;

    const onSubmit = (e)=>{
        e.preventDefault()
        console.log(formData)
        axios.post(apiUrl,formData).then((res)=>{
            if(res.status == 200){
                setSubmitted(true)

                //DISPLAY HERE
                setFormData({...formData, String:'',Seed:''})
            }else{
                alert("Something went wrong please try again")
            }
        })

    }
    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value // Update the specific field in state
        });
    };
  return 
  (
    <form onSubmit={onsubmit}>
        <input type="text" placeholder={'String to' + typeOfAction} name='String' onChange={handleChange}/>
        <input type="text" placeholder='Encryption Seed' name='Seed'  onChange={handleChange} />
        <input type="hidden" name="Encrypt" value={(typeOfAction=="Encrypt")}  onChange={handleChange} />
        <input type="submit" />
    </form>
  )
}


export default form