import {useState} from 'react';
import ReactiveButton from 'reactive-button';

function AnimationButton(props) {
    const [state, setState] = useState('idle');

    const onClickHandler = () => {
        setState('loading');
        setTimeout(() => {
            setState('success');
        }, 2000);
    };

    return <ReactiveButton
        buttonState={state}
        onClick={onClickHandler}
        color={props.color}
        idleText={props.idleText}
        loadingText={props.loadingText}
        successText={props.successText}
        errorText={props.errorText}
        type={props.type}
        className={'class1 class2'}
        style={{ borderRadius: '5px' }}
        outline={props.outline}
        shadow={props.shadow}
        rounded={props.rounded}
        size={props.state}
        block={props.black}
        messageDuration={props.messageDuration}
        disabled={props.disabled}
        buttonRef={props.buttonRef}
        width={props.width}
        height={props.height}
        animation={props.animation}
    />;
}

export default AnimationButton;