import * as React from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import Slide from '@mui/material/Slide';
import { TransitionProps } from '@mui/material/transitions';
import { DeleteForeverOutlined } from '@mui/icons-material';

const Transition = React.forwardRef(function Transition(props, ref) {
    return <Slide direction="up" ref={ref} {...props} />;
  });

const MyCarRowItem = ({idx,row,onDelete}) => {
    const photopath1 = "https://lm6c6d0u3714.edge.naverncp.com/i3dUJJyvi0/mycar";
    const photopath2 = "?type=f&w=40&h=40&faceopt=true&ttype=jpg";
    const storagepath = "https://kr.object.ncloudstorage.com/bitcamp-bucket-91/mycar"; // 스토리지 주소

    // 다이얼로그 이벤트
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const deleteMycar = (num) => {
        let a = window.confirm("해당 상품을 삭제할까요?");
        if (a) {
            onDelete(num);
        }
    }

    return (
        <tr style={{fontSize:'14px'}}>
            <td>
                <img alt='' src={`${photopath1}/${row.carphoto}${photopath2}`}
                border='1' onClick={handleClickOpen} style={{cursor:'pointer'}}/>
                <span style={{marginLeft:'5px'}}>{row.carname}</span>

                <Dialog
                    open={open}
                    TransitionComponent={Transition}
                    keepMounted
                    onClose={handleClose}
                    aria-describedby="alert-dialog-slide-description"
                >
                    <DialogTitle><b>{row.carname}</b></DialogTitle>
                    <DialogContent>
                    <DialogContentText id="alert-dialog-slide-description">
                        <img alt='' src={`${storagepath}/${row.carphoto}`}
                        style={{maxWidth:'400px'}}/>
                    </DialogContentText>
                    </DialogContent>
                    <DialogActions>
                    <Button onClick={handleClose}>닫기</Button>
                    </DialogActions>
                </Dialog>
            </td>
            <td align='right'>{row.carprice}만원</td>
            <td align='center'>
                <div style={{width:'30px',height:'30px',
                    backgroundColor:row.carcolor}}></div>
            </td>
            <td>{row.carguip}</td>
            <td>
                <span style={{color:'gray',fontSize:'13px'}}>
                    {row.writeday}
                    &nbsp;
                    <DeleteForeverOutlined
                    style={{cursor:'pointer'}}
                    onClick={()=>deleteMycar(row.num)}/>
                </span>
            </td>
        </tr>
    );
};

export default MyCarRowItem;